/*
 * Copyright 2017 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.gradle.imagegrinder;

import java.io.File;

import org.junit.Test;

public class ParsedSVGTest extends ResourceHarness {
	@Test
	public void testRender() throws Exception {
		File svg = write("test.svg", readTestResource("refresh.svg"));
		ParsedSVG parsed = ParsedSVG.parse(svg);
		parsed.renderPng(file("test16.png"), Size.create(16, 16));
		parsed.renderPng(file("test32.png"), Size.create(32, 32));
		assertFile("test16.png").isEqualTo(readTestResource("refresh16.png"));
		assertFile("test32.png").isEqualTo(readTestResource("refresh32.png"));
	}
}
