run_all_in_parallel:
	make clean_it test_parallel

clean_it:
	mvn clean

test_parallel:
	make -j test_windows_10_edge_14 test_windows_10_firefox_49

test_windows_10_edge_14:
	mvn install -DbrowserName=MicrosoftEdge -Dversion=14.14393 -Dplatform="Windows 10" -Dsuitename=test_windows_10_edge_14

test_windows_10_firefox_49:
	mvn install -DbrowserName=firefox -Dversion=49.0 -Dplatform="Windows 10" -Dsuitename=test_windows_10_firefox_49

