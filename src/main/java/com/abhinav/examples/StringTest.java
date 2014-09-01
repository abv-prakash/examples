// ========================================================================
// Copyright (c) 2009-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses.
// ========================================================================

package com.abhinav.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* ------------------------------------------------------------ */
/**
 */
public class StringTest {

	/* ------------------------------------------------------------ */
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(final String[] args) throws ParseException {

		searchStringTest();

		String str = "\"2013-04-16 15:12:25.873\"";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		Date date = sdf.parse(str.replaceAll("\"", ""));

		long epoch = date.getTime();

		System.out.println(epoch);

	}

	public static void searchStringTest() {

		String str = "hi this is unique=\"1\" download";

		String substr = "unique=\"1\"";

		if (str.indexOf(substr) != -1) {
			System.out.println("Sub string is present");
		}

	}

}
