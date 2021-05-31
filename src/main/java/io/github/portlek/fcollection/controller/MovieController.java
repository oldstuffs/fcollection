package io.github.portlek.fcollection.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * a class that represents movie controller.
 */
@Data
@RestController
@RequestMapping("movie")
@RequiredArgsConstructor
public class MovieController {

}
