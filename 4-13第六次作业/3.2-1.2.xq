<results>
{
let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
for $cartoon in $cartoons
order by number($cartoon/comments/@score)  descending
return 
<result>
<name>
{$cartoon/name}
</name>
<score>
{$cartoon/comments/@score }
</score>
</result>
}
</results>