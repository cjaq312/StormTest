package com.jagan.storm.spouts;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class MessageSpout implements IRichSpout {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SpoutOutputCollector collector;
	public TopologyContext context;

	int count = 0;

	public void ack(Object arg0) {
	}

	public void activate() {
	}

	public void close() {
	}

	public void deactivate() {
	}

	public void fail(Object arg0) {
	}

	public void nextTuple() {
		if (count == 0) {
			System.out.println("JAGANISAWESOME");
			this.collector.emit(new Values("JAGANISAWESOME"));
			count++;
		}
	}

	public void open(Map map, TopologyContext context, SpoutOutputCollector collector) {
		this.collector = collector;
		this.context = context;

	}

	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("message"));

	}

	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
