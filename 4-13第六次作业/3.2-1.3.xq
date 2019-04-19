<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons
order by number($cartoon/comments/@score)  descending, number($cartoon/serious/@nums)  
return 
<result>
	<name>{$cartoon/name}</name>
	<score>{$cartoon/comments/@score}</score>
	<num>{$cartoon/serials/@nums}</num>
</result>
}
</results>