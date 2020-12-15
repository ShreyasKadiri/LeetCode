# Read from the file file.txt and output the tenth line to stdout.
awk 'FNR == 10 {print }'  file.txt
