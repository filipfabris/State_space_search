# State_space_search

## Implementation of:
+ Breadth first search (BFS)
+  Uniform cost search (UCS)
+ The A* algorithm

## Arguments from command line: 
 + --alg: abbreviation for state space search algorithm (values: bfs, ucs, or astar)
 + --ss: path to state space descriptor file
 + --h: path to heuristic descriptor file
 + --check-optimistic: flag for checking if given heuristic is optimistic
+ --check-consistent: flag for checking if given heuristic is consistent.

## Examples
###  A* algorithm
* using istra.txt as explicitly explicitly defined graph
* using istra_heuristic.txt for heuristic
```bash
mvn compile 
java-cp target/classes ui.Solution--alg astar--ss istra.txt--h istra_heuristic.txt
```
* Output
```
# A-STAR istra_pessimistic_heuristic.txt
[FOUND_SOLUTION]: yes
[STATES_VISITED]: 13
[PATH_LENGTH]: 7
[TOTAL_COST]: 102.0
[PATH]: Pula => Vodnjan => Kanfanar => ˇZminj => Pazin => Motovun => Buzet
```
### BFS algorithm
* Output
```
# BFS
[FOUND_SOLUTION]: yes
[STATES_VISITED]: 11
[PATH_LENGTH]: 5
[TOTAL_COST]: 100.0
[PATH]: Pula => Barban => Labin => Lupoglav => Buzet
```
### UCS algorithm
* Output
```
# UCS
[FOUND_SOLUTION]: yes
[STATES_VISITED]: 17
[PATH_LENGTH]: 5
[TOTAL_COST]: 100.0
[PATH]: Pula => Barban => Labin => Lupoglav => Buzet
```
* Checking if heuristic is optimistic
```
# HEURISTIC-OPTIMISTIC istra_pessimistic_heuristic.txt
[CONDITION]: [OK] h(Baderna) <= h*: 25.0 <= 57.0
[CONDITION]: [OK] h(Barban) <= h*: 35.0 <= 72.0
[CONDITION]: [OK] h(Buje) <= h*: 21.0 <= 41.0
[CONDITION]: [OK] h(Buzet) <= h*: 0.0 <= 0.0
[CONDITION]: [OK] h(Groˇznjan) <= h*: 17.0 <= 33.0
[CONDITION]: [OK] h(Kanfanar) <= h*: 30.0 <= 61.0
[CONDITION]: [OK] h(Labin) <= h*: 35.0 <= 57.0
[CONDITION]: [ERR] h(Lupoglav) <= h*: 35.0 <= 15.0
[CONDITION]: [OK] h(Medulin) <= h*: 61.0 <= 109.0
[CONDITION]: [OK] h(Motovun) <= h*: 12.0 <= 18.0
[CONDITION]: [OK] h(Opatija) <= h*: 26.0 <= 44.0
[CONDITION]: [ERR] h(Pazin) <= h*: 40.0 <= 38.0
[CONDITION]: [OK] h(Poreˇc) <= h*: 32.0 <= 71.0
[CONDITION]: [OK] h(Pula) <= h*: 57.0 <= 100.0
[CONDITION]: [OK] h(Rovinj) <= h*: 40.0 <= 79.0
[CONDITION]: [OK] h(Umag) <= h*: 31.0 <= 54.0
[CONDITION]: [OK] h(Viˇsnjan) <= h*: 20.0 <= 52.0
[CONDITION]: [OK] h(Vodnjan) <= h*: 47.0 <= 90.0
[CONDITION]: [OK] h(ˇZminj) <= h*: 27.0 <= 55.0
[CONCLUSION]: Heuristic is not optimistic.
```

* Checking if heuristic is consistent
```
# HEURISTIC-CONSISTENT istra_pessimistic_heuristic.txt
[CONDITION]: [OK] h(Baderna) <= h(Kanfanar) + c: 25.0 <= 30.0 + 19.0
[CONDITION]: [OK] h(Baderna) <= h(Pazin) + c: 25.0 <= 40.0 + 19.0
[CONDITION]: [OK] h(Baderna) <= h(Poreˇc) + c: 25.0 <= 32.0 + 14.0
[CONDITION]: [OK] h(Baderna) <= h(Viˇsnjan) + c: 25.0 <= 20.0 + 13.0
[CONDITION]: [OK] h(Barban) <= h(Labin) + c: 35.0 <= 35.0 + 15.0
[CONDITION]: [OK] h(Barban) <= h(Pula) + c: 35.0 <= 57.0 + 28.0
[CONDITION]: [OK] h(Buje) <= h(Groˇznjan) + c: 21.0 <= 17.0 + 8.0
[CONDITION]: [OK] h(Buje) <= h(Umag) + c: 21.0 <= 31.0 + 13.0
[CONDITION]: [OK] h(Buzet) <= h(Lupoglav) + c: 0.0 <= 35.0 + 15.0
[CONDITION]: [OK] h(Buzet) <= h(Motovun) + c: 0.0 <= 12.0 + 18.0
[CONDITION]: [OK] h(Groˇznjan) <= h(Buje) + c: 17.0 <= 21.0 + 8.0
[CONDITION]: [OK] h(Groˇznjan) <= h(Motovun) + c: 17.0 <= 12.0 + 15.0
[CONDITION]: [OK] h(Groˇznjan) <= h(Viˇsnjan) + c: 17.0 <= 20.0 + 19.0
[CONDITION]: [OK] h(Kanfanar) <= h(Baderna) + c: 30.0 <= 25.0 + 19.0
[CONDITION]: [OK] h(Kanfanar) <= h(Rovinj) + c: 30.0 <= 40.0 + 18.0
[CONDITION]: [OK] h(Kanfanar) <= h(Vodnjan) + c: 30.0 <= 47.0 + 29.0
[CONDITION]: [OK] h(Kanfanar) <= h(ˇZminj) + c: 30.0 <= 27.0 + 6.0
[CONDITION]: [OK] h(Labin) <= h(Barban) + c: 35.0 <= 35.0 + 15.0
[CONDITION]: [OK] h(Labin) <= h(Lupoglav) + c: 35.0 <= 35.0 + 42.0
[CONDITION]: [ERR] h(Lupoglav) <= h(Buzet) + c: 35.0 <= 0.0 + 15.0
[CONDITION]: [OK] h(Lupoglav) <= h(Labin) + c: 35.0 <= 35.0 + 42.0
[CONDITION]: [OK] h(Lupoglav) <= h(Opatija) + c: 35.0 <= 26.0 + 29.0
[CONDITION]: [OK] h(Lupoglav) <= h(Pazin) + c: 35.0 <= 40.0 + 23.0
[CONDITION]: [OK] h(Medulin) <= h(Pula) + c: 61.0 <= 57.0 + 9.0
[CONDITION]: [OK] h(Motovun) <= h(Buzet) + c: 12.0 <= 0.0 + 18.0
[CONDITION]: [OK] h(Motovun) <= h(Groˇznjan) + c: 12.0 <= 17.0 + 15.0
[CONDITION]: [OK] h(Motovun) <= h(Pazin) + c: 12.0 <= 40.0 + 20.0
[CONDITION]: [OK] h(Opatija) <= h(Lupoglav) + c: 26.0 <= 35.0 + 29.0
[CONDITION]: [OK] h(Pazin) <= h(Baderna) + c: 40.0 <= 25.0 + 19.0
[CONDITION]: [OK] h(Pazin) <= h(Lupoglav) + c: 40.0 <= 35.0 + 23.0
[CONDITION]: [ERR] h(Pazin) <= h(Motovun) + c: 40.0 <= 12.0 + 20.0
[CONDITION]: [OK] h(Pazin) <= h(ˇZminj) + c: 40.0 <= 27.0 + 17.0
[CONDITION]: [OK] h(Poreˇc) <= h(Baderna) + c: 32.0 <= 25.0 + 14.0
[CONDITION]: [OK] h(Pula) <= h(Barban) + c: 57.0 <= 35.0 + 28.0
[CONDITION]: [OK] h(Pula) <= h(Medulin) + c: 57.0 <= 61.0 + 9.0
[CONDITION]: [OK] h(Pula) <= h(Vodnjan) + c: 57.0 <= 47.0 + 12.0
[CONDITION]: [OK] h(Rovinj) <= h(Kanfanar) + c: 40.0 <= 30.0 + 18.0
[CONDITION]: [OK] h(Umag) <= h(Buje) + c: 31.0 <= 21.0 + 13.0
[CONDITION]: [OK] h(Viˇsnjan) <= h(Baderna) + c: 20.0 <= 25.0 + 13.0
[CONDITION]: [OK] h(Viˇsnjan) <= h(Groˇznjan) + c: 20.0 <= 17.0 + 19.0
[CONDITION]: [OK] h(Vodnjan) <= h(Kanfanar) + c: 47.0 <= 30.0 + 29.0
[CONDITION]: [OK] h(Vodnjan) <= h(Pula) + c: 47.0 <= 57.0 + 12.0
[CONDITION]: [OK] h(ˇZminj) <= h(Kanfanar) + c: 27.0 <= 30.0 + 6.0
[CONDITION]: [OK] h(ˇZminj) <= h(Pazin) + c: 27.0 <= 40.0 + 17.0
[CONCLUSION]: Heuristic is not consistent.
```

## A* algorithm for 8-puzzle
* Output
```
# A-STAR 3x3_misplaced_heuristic.txt
[FOUND_SOLUTION]: yes
[STATES_VISITED]: 95544
[PATH_LENGTH]: 31
[TOTAL_COST]: 30.0
[PATH]: 876_543_21x => 876_54x_213 => 876_5x4_213 => 876_x54_213 => 876_254_x13
=> 876_254_1x3 => 876_2x4_153 => 876_24x_153 => 876_243_15x => 876_243_1x5
=> 876_2x3_145 => 8x6_273_145 => x86_273_145 => 286_x73_145 => 286_173_x45
=> 286_173_4x5 => 286_1x3_475 => 2x6_183_475 => 26x_183_475 => 263_18x_475
=> 263_1x8_475 => 2x3_168_475 => x23_168_475 => 123_x68_475 => 123_468_x75
=> 123_468_7x5 => 123_468_75x => 123_46x_758 => 123_4x6_758 => 123_456_7x8
=> 123_456_78x
```

## Execution
```bash
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss 3x3_puzzle.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss 3x3_puzzle.txt --alg ucs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --alg astar --h ai_fail.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --alg astar --h ai_pass.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --h ai_fail.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --h ai_pass.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --h ai_fail.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --h ai_pass.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss ai.txt --alg ucs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --alg astar --h istra_heuristic.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --alg astar --h istra_pessimistic_heuristic.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --h istra_pessimistic_heuristic.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --h istra_heuristic.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --h istra_pessimistic_heuristic.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --h istra_heuristic.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss istra.txt --alg ucs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --alg astar --h test_case_1_heuristic.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --h test_case_1_heuristic.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --h test_case_1_heuristic_nonopt.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --h test_case_1_heuristic.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --h test_case_1_heuristic_nonopt.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_1.txt --alg ucs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --alg astar --h test_case_2_heuristic.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --h test_case_2_heuristic.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --h test_case_2_heuristic_nonopt.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --h test_case_2_heuristic.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --h test_case_2_heuristic_nonopt.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_2.txt --alg ucs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --alg astar --h test_case_3_heuristic.txt
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --alg bfs
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --h test_case_3_heuristic.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --h test_case_3_heuristic_nonopt.txt --check-consistent 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --h test_case_3_heuristic.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --h test_case_3_heuristic_nonopt.txt --check-optimistic 
java -cp target/classes -Dfile.encoding=UTF-8 ui.Solution --ss test_case_3.txt --alg ucs
```
