/**
 * Copyright 2015, Emory University
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
package edu.emory.mathcs.nlp.benchmark;

import java.util.function.Function;

import org.junit.Test;

import edu.emory.mathcs.nlp.component.util.node.NLPNode;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Benchmark
{
	@Test
	public void speed()
	{
		final int iter = 100000000;
		long st, et;
		
		NLPNode node = new NLPNode("A");

		st = System.currentTimeMillis();
		for (int i=0; i<iter; i++)
//			node.getSimplifiedWordForm();
			get(node, NLPNode::getSimplifiedWordForm);
		et = System.currentTimeMillis();
		System.out.println(et-st);
	}
	
	String get(NLPNode node, Function<NLPNode,String> f)
	{
		return f.apply(node);
	}
	
	String get(NLPNode node)
	{
		return node.getSimplifiedWordForm();
	}
}
