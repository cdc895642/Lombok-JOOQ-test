package com.site.jooqtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.junit.Test;

public class StreamTest {

  @Test
  public void streamTest() {
    SendOtherDao sendOtherDao = new SendOtherDao();
    SendOtherRulesDao sendOtherRulesDao = new SendOtherRulesDao();
    List<String> newTickets = sendOtherDao.getNewbies();
    List<SendOtherRule> rules = sendOtherRulesDao.getRules();
    if (newTickets == null || rules == null) {
      return;
    }
    for (String ticket : newTickets) {
      Attachment attachment = getAttachment(ticket);
      int docTypeId = attachment.getVdDoc().getId();
      List<ATSR> atsrs = attachment.getAtsr();
      System.out.println(docTypeId);
      String attrValue = null;
      for (ATSR atsr : atsrs) {
        int attrTypeId = atsr.getId();
        attrValue = atsr.getValue();
        System.out.println(attrTypeId + " - " + attrValue);
      }
      List<SendOtherRule> ruleForUse = rules.stream().filter(
          rule ->
              atsrs.stream().anyMatch(attr -> attr.getId() == rule.docAttrId)
                  &&
                  docTypeId == rule.docTypeId
      ).collect(Collectors.toList());

      String finalAttrValue = attrValue;
      List<Task> tasks = atsrs.stream()
          .map(attr -> getNewTask(rules, finalAttrValue, docTypeId, attr.getId()))
          .filter(attr -> attr != null)
          .collect(Collectors.toList());

//      Function<SendOtherRule,List<Object>> toSend=p -> Arrays.asList(p.getName(), p.getAge());
      System.out.println(ruleForUse.toString());
      System.out.println("TASKS");
      System.out.println(tasks.toString());
    }


  }

  private Task getNewTask(List<SendOtherRule> rules, String finalAttrValue, int docTypeId,
      int attrId) {
    SendOtherRule sendRule = rules.stream().filter(
        rule ->
            docTypeId == rule.docTypeId
                &&
                attrId == rule.docAttrId)
        .findAny().orElse(null);
    Task task = sendRule == null ? null : new Task(sendRule, finalAttrValue);
    return task;
  }

  private Attachment getAttachment(String ticket) {
    return new Attachment(ticket);
  }

  class Task {

    SendOtherRule rule;
    String value;

    public Task(SendOtherRule rule, String value) {
      this.rule = rule;
      this.value = value;
    }

    @Override
    public String toString() {
      return "Task{" +
          "rule=" + rule +
          ", value='" + value + '\'' +
          '}';
    }
  }

  class ATSR {

    int i = 0;

    public ATSR(int i) {
      this.i = i;
    }

    @Override
    public String toString() {
      return "ATSR{" +
          "i=" + i +
          '}';
    }

    int getId() {
      return i;
    }

    String getValue() {
      return "value";
    }
  }

  class VdDoc {

    int i = 0;

    public VdDoc() {
    }

    public VdDoc(int i) {
      this.i = i;
    }

    @Override
    public String toString() {
      return "VdDoc{" +
          "i=" + i +
          '}';
    }

    public int getId() {
      return i;
    }
  }


  class SendOtherRulesDao {

    public List<SendOtherRule> getRules() {
      return Arrays.asList(
          new SendOtherRule(111, 111000),
          new SendOtherRule(222, 222000),
          new SendOtherRule(333, 333000)
      );
    }
  }

  class SendOtherDao {

    public List<String> getNewbies() {
      return Arrays.asList(new String[]{"1", "2", "3"});
    }
  }

  class SendOtherRule {

    int docAttrId = 0;
    int docTypeId = 0;

    public SendOtherRule(int docTypeId, int docAttrId) {
      this.docTypeId = docTypeId;
      this.docAttrId = docAttrId;
    }

    @Override
    public String toString() {
      return "SendOtherRule{" +
          "docAttrId=" + docAttrId +
          ", docTypeId=" + docTypeId +
          '}';
    }

    public int getDocAttrId() {
      return docAttrId;
    }

    public int getDocTypeId() {
      return docTypeId;
    }
  }

  class Attachment {

    String s;

    public Attachment() {
    }

    public Attachment(String s) {
      this.s = s;
    }

    VdDoc getVdDoc() {
      if (s.equals("1")) {
        return new VdDoc(111);
      }
      if (s.equals("2")) {
        return new VdDoc(222);
      }
      if (s.equals("3")) {
        return new VdDoc(333);
      }
      return new VdDoc();
    }

    public List<ATSR> getAtsr() {
      return Arrays.asList(
          new ATSR(111000),
          new ATSR(222000),
          new ATSR(333000),
          new ATSR(111000),
          new ATSR(333000)
      );
    }
  }
}
