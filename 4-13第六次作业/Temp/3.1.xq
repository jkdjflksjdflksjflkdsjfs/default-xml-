<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons[position()<=5]
return 
<result>
	{$cartoon}
</result>
}
{
let $cartoons := doc("new_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons
return 
<result>
	{$cartoon}
</result>
}
</results>


