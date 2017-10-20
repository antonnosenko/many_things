Meta:

Narrative:
As a user
I want to use google calculator
So that I can make some simple calculations

Scenario: some simple calculations using calculator buttons
Given google calculator page
When press the buttons <num1> <operator> <num2>
Then the answer is <result>

Examples:
|num1|operator|num2|result|
|1|+|5|6|
|1|+|0|1|
|-1|+|1|0|
|0|-|100|-100|
|12|-|12|0|
|-256|-|123|-379|
|8|/|2|4|
|-10|/|5|-2|
|21|/|3|7|
|12|/|0|Infinity|
|0|/|0|Error|
|2|*|2|4|
|1|*|0|0|
|43|*|-1|-43|


Scenario: some simple calculations using calculator input field
Given google calculator page
When input in field <num1> <operator> <num2>
Then the answer is <result>

Examples:
|num1|operator|num2|result|
|1|+|5|6|
|1|+|0|1|
|-1|+|1|0|
|0|-|100|-100|
|12|-|12|0|
|-256|-|123|-379|
|8|/|2|4|
|-10|/|5|-2|
|21|/|3|7|
|12|/|0|Infinity|
|0|/|0|Error|
|2|*|2|4|
|1|*|0|0|
|43|*|-1|-43|

