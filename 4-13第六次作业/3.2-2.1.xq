<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons 
	 where number($cartoon/serials/@nums) > 50
return 
<result>
	<name>{$cartoon/name}</name>
	<num>{$cartoon/serials/@nums}</num>
</result>
}
</results>