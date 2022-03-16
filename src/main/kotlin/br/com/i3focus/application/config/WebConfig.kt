package br.com.i3focus.application.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.ServerProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.server.WebFilter

@Configuration
class WebConfig {
    @Autowired lateinit var serverProperties: ServerProperties

    @Bean
    fun contextPathWebFilter(): WebFilter {
        val contextPath = serverProperties.servlet.contextPath
        return WebFilter { exchange, chain ->
            val request = exchange.request
            if (request.uri.path.startsWith(contextPath)) {
                chain.filter(
                    exchange.mutate()
                        .request(request.mutate().contextPath(contextPath).build())
                        .build())
            } else {
                chain.filter(exchange)
            }
        }
    }
}