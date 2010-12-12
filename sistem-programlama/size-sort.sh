#!/bin/bash

du $(readlink -f $HOME)/* |sort -n >>/tmp/x
file=`cat /tmp/x |sort -r`
a=0
for ch in $path/*; do
	if [ $a -ne 5 ]; then
		a=$((a+1))
		echo $ch
	fi
done 
