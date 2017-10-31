Feature: Create new order
  User can create a new order.
  Background: login user

    When login user
      |username|2|
      |password|123456|
      |verifycode|imqa|
    And switch system: 视频


  Scenario: Create new order

    Given navigate: order_list
    When new order
    And stock query
      |type|cpm|
      |date|0;1|
      |adr|视频广告.通用位置.通用前贴|
      |area|中国.江苏.南京|
      |exam|1;2;3|
      |throwtype|3|
      |tracker|adbug.ba.1|
    And add new order
      |schedule|0|
      |submit|加入|
      |cpm|1    |
    And fill order
      |name|订单111|
      |adv|六间房|
      |ordertype|2|
      |specialflow|1|
      |submit|提交    |
    Then check order
      |类型|询量|
      |状态|审批中|

