#!/bin/sh

path=$(readlink -f $HOME/..)/*
echo "Maximum kota miktarını giriniz"
read kota
echo "kotayi aşan kullanıcılar"
for i in $path; do
        a=`du -s $i |cut -d ' ' -f1`
        if [ $a -gt $kota ]; then
		echo $i
	fi
done
