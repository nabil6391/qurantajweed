## Tajweed Highlighting Experiments

بسم الله الرحمن الرحيم
*In the name of Allah, Most Gracious, Most Merciful*

The purpose of this project is to experiment with "tajweed syntax highlighting," or writing algorithms to color code the various tajweed rules as is found in the tajweed mus7af. There is currently a mode for the standard madani tajweed mus7af and another for the naskh tajweed mus7af (which highlight tajweed slightly differently). The highlighting is based on regex pattern matching in the unicode arabic to find the appropiate tajweeds and apply coloring to them.

# Presently these are patterns that are matched
1. Gunnah
2. Qalqalah
3. Iqlab
4. Idhgham with and with gunnah
5. Ikhfa

# Others patterns that can be matched
1. Hamzatul Wasl patterns
2. Madd elongation for 2 , 4 and 6 

An issue is already present in our al quran repo
https://gitlab.com/greentech/quran/quran-android/-/issues/284


**Note:** this project is still a work in progress. It is by no means complete, nor does it perfectly match the tajweed mus7af yet. It is being open sourced in case people in the community would like to help accelerate its development.

