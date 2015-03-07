/*******************************************************************************
 * Copyright (c) 2015 Gary F. Pollice
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Used in CS4533/CS544 at Worcester Polytechnic Institute
 *******************************************************************************/

package dijkstra.gen;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * @version Feb 22, 2015
 */
public class JVMInfo
{
	private static final Map<String, Integer> m = new HashMap<>();
	
	
	public static int addressOf(String name)
	{
		Integer i = m.get(name);
		if (i == null)
		{
			m.put(name, m.size());
		}
		
		return m.get(name);
	}


	public static void reset()
	{
		m.clear();
	}
}
