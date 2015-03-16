/*
 * 0blivi0n-cache
 * ==============
 * Java REST Client
 * 
 * Copyright (C) 2015 Joaquim Rocha <jrocha@gmailbox.org>
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package net.uiqui.oblivion.client.api.util;

import java.util.ArrayList;
import java.util.List;

public class URLBuilder {
	private final List<String> parts = new ArrayList<String>();

	public URLBuilder(final String url) {
		final String[] frags = url.split("%s");

		for (String s : frags) {
			parts.add(s);
		}
	}

	public String build(final Object... args) {
		final StringBuilder builder = new StringBuilder();

		int index = 0;

		for (String s : parts) {
			builder.append(s);

			if (index < args.length) {
				builder.append(args[index]);
				index++;
			}
		}

		return builder.toString();
	}
}