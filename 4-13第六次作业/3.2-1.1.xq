<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons
order by number($cartoon/serials/@nums)
return 
<result>
<name>{$cartoon/name}</name>
<serious>{$cartoon/serials/@nums}</serious>
</result>
}
</results>