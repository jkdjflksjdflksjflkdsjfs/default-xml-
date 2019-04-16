<scores>
{
    let $score_list := (1,2,3,4,5,6,7,8,9)
for $score in $score_list
return 
	<score number="{$score}">
	{
			let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
			for $cartoon in  doc("cartoons-with-country.xml")/cartoons/cartoon
				let $num := $cartoon/comments/@score
				where ceiling(number($num)) = $score
				return
					<cartoon name="{$cartoon/name}">
						<made_info>{$cartoon/made_info/*}</made_info>
					</cartoon>
	}
	</score>
}
</scores>