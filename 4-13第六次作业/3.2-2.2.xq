<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons 
	 where number($cartoon/comments/@score) < 7
return 
<result>
	<name>{$cartoon/name}</name>
	<score>{$cartoon/comments/@score}</score>
</result>
}
</results>