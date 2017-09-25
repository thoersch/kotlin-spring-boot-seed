package org.thoersch.poc.kotlin.rest

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE), produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
abstract class BaseController
