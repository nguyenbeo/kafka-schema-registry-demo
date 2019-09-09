package se.mikka.kafka

import groovy.io.FileType
import groovy.json.StringEscapeUtils

def list = []

def dir = new File("./producer/src/main/resources/kafka_schema_registry")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

list.each {
  def topicSchema = new String(it.bytes)
  def formatTopicSchema = "{ \"schema\": \"" + StringEscapeUtils.escapeJava(topicSchema) + "\" }"
  def response = ["curl", "-X", "POST", "-H", "Content-Type: application/vnd.schemaregistry.v1+json", "--data", formatTopicSchema, "http://localhost:8081/subjects/kafka-topic-name/versions"].execute().text
  println "Response: " + response
}