package com.codingnomads.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("FullHD")
@Primary
public class FullHD implements Screen {
}
