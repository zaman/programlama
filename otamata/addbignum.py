#!/usr/bin/python
#!-*- coding:utf-8 
sayi1 = raw_input("Lütfen sayı1 giriniz : ")
sayi2 = raw_input("Lütfen sayı2 giriniz : ")
basamak1 = len(sayi1)
basamak2 = len(sayi2)
spsayi1 = []
spsayi2 = []
sptoplam = []
if (basamak1 >= basamak2):
	direk = basamak1 - basamak2
	fazla1 = basamak1 % 20
	fazla2 = basamak2  % 20
	for i in range (basamak1,direk + fazla1,-20):
		spsayi1.append(sayi1[i-20:i])
	for j in range (basamak2,fazla2,-20):
		spsayi2.append(sayi2[j-20:j])
	elde = 0
	for k in range (0,basamak2 / 20):
		toplam = 0
		toplam = int (spsayi1.pop()) + int (spsayi2.pop()) + elde
		toplam = str (toplam)
		sptoplam.append(toplam)
		if (len(toplam) > 20):
			elde = 1
		else:
			elde = 0
	fazla = int (sayi1[direk:direk+fazla1]) + int (sayi2[0:fazla2])
	fazla = str (fazla)
	sonuc = sayi1[0:direk]+ fazla +"".join(sptoplam)
	print sonuc
