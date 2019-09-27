package com.introvd.template.plugin.downloader.p373d;

import com.introvd.template.plugin.downloader.entity.C8316d;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.ParseException;
import okhttp3.C9804ad;
import p037b.p050b.C1512e;
import p469f.C9768m;

/* renamed from: com.introvd.template.plugin.downloader.d.b */
public class C8301b {
    private int dZW;
    private int eaR;

    public C8301b(int i) {
        this.dZW = i;
        this.eaR = i * 16;
    }

    /* renamed from: a */
    private long m23947a(MappedByteBuffer mappedByteBuffer) {
        long j = 0;
        for (int i = 0; i < this.dZW; i++) {
            int i2 = i * 16;
            j += (mappedByteBuffer.getLong(i2 + 8) - mappedByteBuffer.getLong(i2)) + 1;
        }
        return j;
    }

    /* renamed from: a */
    private void m23948a(File file, File file2, long j) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        long j2;
        long j3;
        FileChannel fileChannel = null;
        try {
            randomAccessFile2 = new RandomAccessFile(file2, "rw");
            try {
                randomAccessFile2.setLength(j);
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    randomAccessFile.setLength((long) this.eaR);
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, (long) this.eaR);
                        int i = (int) (j / ((long) this.dZW));
                        for (int i2 = 0; i2 < this.dZW; i2++) {
                            if (i2 == this.dZW - 1) {
                                j3 = (long) (i2 * i);
                                j2 = j - 1;
                            } else {
                                j3 = (long) (i2 * i);
                                j2 = (long) (((i2 + 1) * i) - 1);
                            }
                            map.putLong(j3);
                            map.putLong(j2);
                        }
                        C8302c.closeQuietly(channel);
                        C8302c.closeQuietly(randomAccessFile);
                        C8302c.closeQuietly(randomAccessFile2);
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        C8302c.closeQuietly(fileChannel);
                        C8302c.closeQuietly(randomAccessFile);
                        C8302c.closeQuietly(randomAccessFile2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    C8302c.closeQuietly(fileChannel);
                    C8302c.closeQuietly(randomAccessFile);
                    C8302c.closeQuietly(randomAccessFile2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                C8302c.closeQuietly(randomAccessFile2);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            randomAccessFile2 = null;
            C8302c.closeQuietly(fileChannel);
            C8302c.closeQuietly(randomAccessFile);
            C8302c.closeQuietly(randomAccessFile2);
            throw th;
        }
    }

    /* renamed from: d */
    private void m23949d(File file, String str) throws IOException, ParseException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile.setLength(8);
                randomAccessFile.seek(0);
                randomAccessFile.writeLong(C8310g.m23986ns(str));
                C8302c.closeQuietly(randomAccessFile);
            } catch (Throwable th) {
                th = th;
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    /* renamed from: f */
    private void m23950f(File file, long j) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            if (j != -1) {
                try {
                    randomAccessFile2.setLength(j);
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    C8302c.closeQuietly(randomAccessFile);
                    throw th;
                }
            } else {
                C8304e.log("chunked download!");
            }
            C8302c.closeQuietly(randomAccessFile2);
        } catch (Throwable th2) {
            th = th2;
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    /* renamed from: B */
    public boolean mo33481B(File file) throws IOException {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Throwable th;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
            try {
                MappedByteBuffer map = fileChannel.map(MapMode.READ_WRITE, 0, (long) this.eaR);
                for (int i = 0; i < this.dZW; i++) {
                    if (map.getLong() <= map.getLong()) {
                        C8302c.closeQuietly(fileChannel);
                        C8302c.closeQuietly(randomAccessFile);
                        return true;
                    }
                }
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                return false;
            } catch (Throwable th3) {
                th = th3;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th4) {
            randomAccessFile = null;
            th = th4;
            fileChannel = null;
            C8302c.closeQuietly(fileChannel);
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    /* renamed from: C */
    public String mo33482C(File file) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                randomAccessFile2.seek(0);
                String aU = C8310g.m23985aU(randomAccessFile2.readLong());
                C8302c.closeQuietly(randomAccessFile2);
                return aU;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    /* renamed from: a */
    public void mo33483a(C1512e<DownloadStatus> eVar, int i, File file, File file2, File file3, C9804ad adVar) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        FileChannel fileChannel2;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        FileChannel channel;
        RandomAccessFile randomAccessFile4;
        FileChannel fileChannel3;
        C1512e<DownloadStatus> eVar2 = eVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Thread: ");
        sb.append(Thread.currentThread().getName());
        sb.append("; saveFile start, content length: ");
        sb.append(adVar.contentLength());
        C8304e.log(sb.toString());
        try {
            byte[] bArr = new byte[2048];
            DownloadStatus downloadStatus = new DownloadStatus();
            RandomAccessFile randomAccessFile5 = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile5.getChannel();
            } catch (Throwable th) {
                th = th;
                randomAccessFile3 = randomAccessFile5;
                randomAccessFile2 = null;
                fileChannel2 = null;
                inputStream = null;
                fileChannel = null;
                C8302c.closeQuietly(randomAccessFile);
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile2);
                C8302c.closeQuietly(fileChannel2);
                C8302c.closeQuietly(inputStream);
                C8302c.closeQuietly(adVar);
                throw th;
            }
            try {
                MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, (long) this.eaR);
                int i2 = i * 16;
                long j = map.getLong(i2);
                long j2 = map.getLong(this.eaR - 8) + 1;
                downloadStatus.mo33493aS(j2);
                randomAccessFile2 = new RandomAccessFile(file2, "rw");
                try {
                    fileChannel2 = randomAccessFile2.getChannel();
                    try {
                        InputStream byteStream = adVar.byteStream();
                        long j3 = j;
                        while (true) {
                            try {
                                int read = byteStream.read(bArr);
                                inputStream = byteStream;
                                if (read == -1) {
                                    break;
                                }
                                try {
                                    if (eVar.isCancelled()) {
                                        break;
                                    }
                                    randomAccessFile = randomAccessFile5;
                                    fileChannel = channel;
                                    long j4 = (long) read;
                                    MappedByteBuffer map2 = fileChannel2.map(MapMode.READ_WRITE, j, j4);
                                    j += j4;
                                    if (j - j3 > 100000) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Thread: ");
                                        sb2.append(Thread.currentThread().getName());
                                        sb2.append("; saveLenRead: ");
                                        sb2.append(j);
                                        C8304e.log(sb2.toString());
                                        j3 = j;
                                    }
                                    map2.put(bArr, 0, read);
                                    map.putLong(i2, j);
                                    downloadStatus.mo33494aT(j2 - m23947a(map));
                                    eVar2.mo9791K(downloadStatus);
                                    byteStream = inputStream;
                                    randomAccessFile5 = randomAccessFile;
                                    channel = fileChannel;
                                } catch (Throwable th2) {
                                    th = th2;
                                    C8302c.closeQuietly(randomAccessFile);
                                    C8302c.closeQuietly(fileChannel);
                                    C8302c.closeQuietly(randomAccessFile2);
                                    C8302c.closeQuietly(fileChannel2);
                                    C8302c.closeQuietly(inputStream);
                                    C8302c.closeQuietly(adVar);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = byteStream;
                                randomAccessFile = randomAccessFile5;
                                fileChannel = channel;
                                C8302c.closeQuietly(randomAccessFile);
                                C8302c.closeQuietly(fileChannel);
                                C8302c.closeQuietly(randomAccessFile2);
                                C8302c.closeQuietly(fileChannel2);
                                C8302c.closeQuietly(inputStream);
                                C8302c.closeQuietly(adVar);
                                throw th;
                            }
                        }
                        randomAccessFile4 = randomAccessFile5;
                        fileChannel3 = channel;
                        file2.renameTo(file3);
                        eVar.onComplete();
                    } catch (Throwable th4) {
                        th = th4;
                        randomAccessFile = randomAccessFile5;
                        fileChannel = channel;
                        inputStream = null;
                        C8302c.closeQuietly(randomAccessFile);
                        C8302c.closeQuietly(fileChannel);
                        C8302c.closeQuietly(randomAccessFile2);
                        C8302c.closeQuietly(fileChannel2);
                        C8302c.closeQuietly(inputStream);
                        C8302c.closeQuietly(adVar);
                        throw th;
                    }
                    try {
                        C8302c.closeQuietly(randomAccessFile4);
                        C8302c.closeQuietly(fileChannel3);
                        C8302c.closeQuietly(randomAccessFile2);
                        C8302c.closeQuietly(fileChannel2);
                        C8302c.closeQuietly(inputStream);
                        C8302c.closeQuietly(adVar);
                    } catch (IOException e) {
                        eVar2.onError(e);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile = randomAccessFile5;
                    fileChannel = channel;
                    fileChannel2 = null;
                    inputStream = null;
                    C8302c.closeQuietly(randomAccessFile);
                    C8302c.closeQuietly(fileChannel);
                    C8302c.closeQuietly(randomAccessFile2);
                    C8302c.closeQuietly(fileChannel2);
                    C8302c.closeQuietly(inputStream);
                    C8302c.closeQuietly(adVar);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile = randomAccessFile5;
                fileChannel = channel;
                randomAccessFile2 = null;
                fileChannel2 = null;
                inputStream = null;
                C8302c.closeQuietly(randomAccessFile);
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile2);
                C8302c.closeQuietly(fileChannel2);
                C8302c.closeQuietly(inputStream);
                C8302c.closeQuietly(adVar);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            randomAccessFile2 = null;
            fileChannel2 = null;
            inputStream = null;
            randomAccessFile3 = null;
            fileChannel = null;
            C8302c.closeQuietly(randomAccessFile);
            C8302c.closeQuietly(fileChannel);
            C8302c.closeQuietly(randomAccessFile2);
            C8302c.closeQuietly(fileChannel2);
            C8302c.closeQuietly(inputStream);
            C8302c.closeQuietly(adVar);
            throw th;
        }
    }

    /* renamed from: a */
    public void mo33484a(C1512e<DownloadStatus> eVar, File file, File file2, C9768m<C9804ad> mVar) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[8192];
            DownloadStatus downloadStatus = new DownloadStatus();
            inputStream = ((C9804ad) mVar.baI()).byteStream();
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                C8302c.closeQuietly(inputStream);
                C8302c.closeQuietly(fileOutputStream);
                C8302c.closeQuietly((Closeable) mVar.baI());
                throw th;
            }
            try {
                long contentLength = ((C9804ad) mVar.baI()).contentLength();
                if (C8303d.m23967j(mVar) || contentLength == -1) {
                    downloadStatus.eav = true;
                }
                downloadStatus.mo33493aS(contentLength);
                int i = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1 || eVar.isCancelled()) {
                        fileOutputStream.flush();
                        file.renameTo(file2);
                        eVar.onComplete();
                    } else {
                        fileOutputStream.write(bArr, 0, read);
                        i += read;
                        downloadStatus.mo33494aT((long) i);
                        eVar.mo9791K(downloadStatus);
                    }
                }
                fileOutputStream.flush();
                file.renameTo(file2);
                eVar.onComplete();
                try {
                    C8302c.closeQuietly(inputStream);
                    C8302c.closeQuietly(fileOutputStream);
                    C8302c.closeQuietly((Closeable) mVar.baI());
                } catch (IOException | SecurityException e) {
                    eVar.onError(e);
                }
            } catch (Throwable th2) {
                th = th2;
                C8302c.closeQuietly(inputStream);
                C8302c.closeQuietly(fileOutputStream);
                C8302c.closeQuietly((Closeable) mVar.baI());
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            fileOutputStream = null;
            C8302c.closeQuietly(inputStream);
            C8302c.closeQuietly(fileOutputStream);
            C8302c.closeQuietly((Closeable) mVar.baI());
            throw th;
        }
    }

    /* renamed from: a */
    public void mo33485a(File file, File file2, long j, String str) throws IOException, ParseException {
        m23949d(file, str);
        m23950f(file2, j);
    }

    /* renamed from: a */
    public void mo33486a(File file, File file2, File file3, long j, String str) throws IOException, ParseException {
        m23949d(file, str);
        m23948a(file2, file3, j);
    }

    /* renamed from: d */
    public C8316d mo33487d(File file, int i) throws IOException {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer map = fileChannel.map(MapMode.READ_WRITE, (long) (i * 16), (long) ((i + 1) * 16));
                    C8316d dVar = new C8316d(map.getLong(), map.getLong());
                    C8302c.closeQuietly(fileChannel);
                    C8302c.closeQuietly(randomAccessFile);
                    return dVar;
                } catch (Throwable th) {
                    th = th;
                    C8302c.closeQuietly(fileChannel);
                    C8302c.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
            C8302c.closeQuietly(fileChannel);
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    /* renamed from: e */
    public boolean mo33488e(File file, long j) throws IOException {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
            try {
                boolean z = fileChannel.map(MapMode.READ_WRITE, 0, (long) this.eaR).getLong(this.eaR + -8) + 1 != j;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                return z;
            } catch (Throwable th2) {
                th = th2;
                C8302c.closeQuietly(fileChannel);
                C8302c.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
            C8302c.closeQuietly(fileChannel);
            C8302c.closeQuietly(randomAccessFile);
            throw th;
        }
    }
}
