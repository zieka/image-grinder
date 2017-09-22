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

import org.gradle.api.NamedDomainObjectFactory;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ImageGrinderPlugin implements Plugin<Project> {
	private static final String NAME = "imageGrinder";

	@Override
	public void apply(Project project) {
		project.getExtensions().add(NAME, project.container(ImageGrinderTask.class, new NamedDomainObjectFactory<ImageGrinderTask>() {
			@Override
			public ImageGrinderTask create(String name) {
				ImageGrinderTask task = project.getTasks().create(name, ImageGrinderTask.class);
				return task;
			}
		}));
	}
}
