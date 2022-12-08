package jna

import com.sun.jna.Pointer
import com.sun.jna.platform.win32.WinNT.HANDLE
import utils.Constants.MAP_SIZE
import utils.Constants.SHARED_MEM_FILE_ACCESS
import utils.Constants.SHARED_MEM_FILE_NAME


class Ets2Kernel32Impl {

    fun openFileMapping(): HANDLE? {
        return Ets2Kernel32.instance.OpenFileMapping(
            SHARED_MEM_FILE_ACCESS,
            false,
            SHARED_MEM_FILE_NAME
        )
    }

    fun getMapView(memMapFile: HANDLE): Pointer? = Ets2Kernel32.instance.MapViewOfFile(
            memMapFile,
            SHARED_MEM_FILE_ACCESS,
            0,
            0,
            MAP_SIZE
        )
}