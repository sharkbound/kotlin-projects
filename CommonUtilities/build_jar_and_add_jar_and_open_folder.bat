call gradle clean
call gradle jar

call add_jar.bat
cd ../../
call open_lib_folder.bat

exit