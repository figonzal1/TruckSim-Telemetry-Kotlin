package jna

import com.sun.jna.Native
import com.sun.jna.platform.win32.Kernel32
import com.sun.jna.platform.win32.WinNT.HANDLE
import com.sun.jna.win32.W32APIOptions

interface Ets2Kernel32 : Kernel32 {

    //Load lib to read shared mapping file
    companion object {
        @JvmField
        val instance: Ets2Kernel32 = Native.load("kernel32", Ets2Kernel32::class.java, W32APIOptions.DEFAULT_OPTIONS)
    }


    //Interface
    override fun OpenFileMapping(fileAccess: Int, bInherit: Boolean, filename: String): HANDLE?
}