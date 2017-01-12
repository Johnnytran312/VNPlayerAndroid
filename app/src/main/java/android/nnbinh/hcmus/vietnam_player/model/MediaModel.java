package android.nnbinh.hcmus.vietnam_player.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nguyenngocbinh on 1/6/17.
 */

public class MediaModel extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private String albumName;
    private String artistName;
    private String thumbUrl;
    private Float size;
    private String lyric;
    private boolean isLocal;

    public MediaModel() {

    }

    public MediaModel(long id, String name, String thumbUrl, String artistName, boolean isLocal) {
        this.id = id;
        this.name = name;
        this.thumbUrl = thumbUrl;
        this.artistName = artistName;
        this.isLocal = isLocal;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }
}
