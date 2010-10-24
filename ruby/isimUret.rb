def bir (ad)
        file = File.new("imla", "r")
        while (line = file.gets)
                if ((ad <=> line) == 1)
                        puts(line)
                end
        end
file.close
end

def iki (ad,soyad)
	puts(ad+"."+soyad)
	puts(ad[0].chr+(ad[1..(ad.size)].delete "aeoui")+soyad[0].chr+(soyad[1..(soyad.size)].delete "aeoui"))
	a = ad[0].chr + soyad
	puts(a)
end

def uc (ad,ad2,soyad)
	puts(ad+"."+soyad)
	puts(ad2+"."+soyad)
	puts(ad[0].chr+ad2[0].chr+soyad[0].chr+(soyad[1..(soyad.size)].delete "aeoui"))
	puts(ad[0].chr+(ad[1..(ad.size)].delete "aeoui")+soyad[0].chr+(soyad[1..(soyad.size)].delete "aeoui"))
	puts(ad2[0].chr+(ad2[1..(ad.size)].delete "aeoui")+soyad[0].chr+(soyad[1..(soyad.size)].delete "aeoui"))
	
	
end	

puts ("Lütfen adınızı ve soyadınızı arasında bir bosluk olacak şekilde giriniz")
ad = gets
ad = ad.downcase
ad = ad.split
if ad.size == 2
	iki(ad[0],ad[1])
	iki1(ad[0],ad[1])
end

if ad.size ==3
	uc(ad[0],ad[1],ad[2])
end
