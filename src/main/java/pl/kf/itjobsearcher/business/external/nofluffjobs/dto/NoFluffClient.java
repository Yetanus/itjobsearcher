package pl.kf.itjobsearcher.business.external.nofluffjobs.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

/**
 * Class ,which uses {@link RestClient} to retrive data from noFluffJobs website.
 */
@Service
public class NoFluffClient {
    private final RestClient NoFluffWebClient;

    @Autowired
    public NoFluffClient(RestClient NoFluffWebClient){
        this.NoFluffWebClient = NoFluffWebClient;
    }

}
