package com.jagan.storm.bolts;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

public class MessageBolt implements IRichBolt {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OutputCollector collector;

	public void cleanup() {
		// TODO Auto-generated method stub

	}

	public void declareOutputFields(OutputFieldsDeclarer arg0) {
//		arg0.declare(new Fields("message"));

	}

	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public void execute(Tuple tuple) {
		System.out.println("TUPLE IS HERE :: " + tuple.getValues());
		collector.ack(tuple);
	}

	public void prepare(Map map, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
	}

}
