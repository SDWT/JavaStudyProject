package com.example.anime.chain;

import java.util.List;

import com.example.anime.model.Anime;

public abstract class FilterHandler {
    protected FilterHandler next;

    public FilterHandler setNext(FilterHandler next)
    {
        this.next = next;
        return next;
    }

    public List<Anime> handle(List<Anime> animes)
    {
        List<Anime> filtered = applyFilter(animes);

        if (next != null)
            return next.handle(filtered);
        return filtered;
    }

    protected abstract List<Anime> applyFilter(List<Anime> animes);
}

public class GenreFilter extends FilterHandler {

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyFilter'");
    }
    
}

public class StudioFilter extends FilterHandler {

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyFilter'");
    }
    
}

public class YearFilter extends FilterHandler {

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyFilter'");
    }
    
}

public class RatingFilter extends FilterHandler {

    @Override
    protected List<Anime> applyFilter(List<Anime> animes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyFilter'");
    }
    
}

