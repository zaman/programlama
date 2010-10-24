sayi = rand(100)
i=0
puts("iyi sanslar")
while (1)
	i +=1
	puts("lutfen tahmininizi giriniz")
	girdi = gets
	new = girdi.to_i
	if new == sayi and i <10
		puts("tebrikler sayiyi ,#{i},tahminde buldunuz")
		break
	end
	if new !=sayi and i <10
		puts("sayiyi buyultunuz") if new < sayi
		puts("sayiyi kucultunuz") if new > sayi
	end
	if i ==10
		puts("Sayiyi bulamadiniz")
		break
	end
end
			
