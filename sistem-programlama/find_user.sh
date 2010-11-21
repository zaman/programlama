file=/etc/passwd
read ad
if cat $file |grep $ad 1>/dev/null
then
	echo "{$ad} isimli kullanici bulundu"
else
	echo "{ad} isimli kullanici bulunamadi"
fi
