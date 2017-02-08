package com.jagan.storm.toplogy;

import com.jagan.storm.bolts.MessageBolt;
import com.jagan.storm.spouts.MessageSpout;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class MessageTopology {
	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();

		builder.setSpout("test-spout", new MessageSpout());
		builder.setBolt("test-bolt", new MessageBolt()).globalGrouping("test-spout");

		LocalCluster cluster = new LocalCluster();

		Config config = new Config();
		config.setDebug(true);

		cluster.submitTopology("testCluster", config, builder.createTopology());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Stop the topology
		// cluster.killTopology("testCluster");
		// cluster.shutdown();
	}
}
