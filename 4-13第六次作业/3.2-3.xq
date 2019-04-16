<countries>
{
for $country in distinct-values(doc("cartoons-with-country.xml")/cartoons/cartoon/country)
return 
	<country name="{$country}">
	{
			let $cartoons := doc("old_cartoons.xml")/cartoons/cartoon
			for $cartoon in  doc("cartoons-with-country.xml")/cartoons/cartoon
				let $regin := $cartoon/country
				where $country = $regin
				return
					<cartoon name="{$cartoon/name}">
						<made_info>{$cartoon/made_info/*}</made_info>
					</cartoon>
	}
	</country>
}
</countries>