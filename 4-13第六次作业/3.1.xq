<results>
 {
 let $oldCartoonList :=(
   for $someCartoons in doc("old_cartoons.xml")/cartoons/cartoon
   where $someCartoons/comments/@score < 8

   return 
 <cartoon>
    {$someCartoons/@*}
    {$someCartoons/*}
 </cartoon>
 )
 
 let $newCartoonList :=(
   for $otherCartoons in doc("new_cartoons.xml")/cartoons/cartoon
   return 
 <cartoon>
    {$otherCartoons/@*}
    {$otherCartoons/*}
 </cartoon>
 )
 
 
return 
<combineCartoons>
{$oldCartoonList}
{$newCartoonList}
</combineCartoons>
 }

</results>


