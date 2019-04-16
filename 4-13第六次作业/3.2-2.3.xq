<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons 
	 where number($cartoon/comments/@score) > 9 and number($cartoon/serials/@nums) > 100
return 
<result>
	<name>{$cartoon/name}</name>
	<score>{$cartoon/comments/@score}</score>
	<nums>{$cartoon/serials/@nums}</nums>
</result>
}
</results>