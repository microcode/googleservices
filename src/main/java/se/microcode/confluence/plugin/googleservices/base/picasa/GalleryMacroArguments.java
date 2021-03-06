/*

Copyright (c) 2011, Jesper Svennevid
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice,
   this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
 * Neither the name of microcode.se nor the names of its contributors may be
   used to endorse or promote products derived from this software without
   specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.

 */

package se.microcode.confluence.plugin.googleservices.base.picasa;

import se.microcode.base.Argument;
import se.microcode.base.ArgumentSource;

public class GalleryMacroArguments
{
    public GalleryMacroArguments()
    {
        pageSize = -1;
        imageSize = 640;
        thumbnails = 5;
        albumSize = "144u";
        thumbSize = "72u";
    }

    public String user;
    public int pageSize;
    public int imageSize;
    public String albumSize;
    public int thumbnails;
    public String thumbSize;

    @Argument(name = "album", source = ArgumentSource.EXTERNAL)
    public String album;
    @Argument(name = "photo", source = ArgumentSource.EXTERNAL)
    public String photo;
    @Argument(name = "page", source = ArgumentSource.EXTERNAL)
    public int page;
    @Argument(name = "pageId", source = ArgumentSource.EXTERNAL)
    public int pageId;
}
