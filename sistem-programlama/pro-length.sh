#!/bin/bash

# listele
path=/usr/bin
b=`expr length $path`
for ch in $path/*; do
	a=$((`expr length $ch`-b))
	if [ $a -le 3 ]; then
		echo -n $ch
	fi
done
