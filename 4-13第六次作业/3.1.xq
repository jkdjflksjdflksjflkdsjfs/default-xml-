<results>
 {
 let $xml1 := doc("old_cartoons.xml")/cartoons/cartoon
 let $xml2 := doc("new_cartoons.xml")/cartoons/cartoon

 for $someCartoons in $xml1,$otherCartoons in $xml2
 where $someCartoons/comments/@score < 8

 return 
 <result>
    {$someCartoons}
    {$otherCartoons}
 </result>
 
 }

</results>



