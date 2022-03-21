package datamodel;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import retrofit.NewsApiRepository;

public class NewsViewModelTest extends TestCase {

    private NewsViewModel newsViewModel;


    @Before
    public void setUp() {

    }
    @Test
    public void testGetHeadline() {
        newsViewModel = new NewsViewModel(new NewsApiRepository());
        assertNotNull(newsViewModel.getHeadlineData());
    }
}