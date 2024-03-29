package guru.springframework.msscbrewery.web.controller.v2;


import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {


    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerServiceV2 = beerService;
    }


    @GetMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BeerDtoV2 getBeer(@PathVariable UUID beerId) {
        return beerServiceV2.getBeerById(beerId);
    }

    @PostMapping
    public ResponseEntity<BeerDto> createBeer(@RequestBody BeerDtoV2 beerDto) {
        BeerDtoV2 savedDto = beerServiceV2.createBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("location", "/api/v1/beer" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        beerServiceV2.updateBeer(beerId, beerDto);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(UUID beerId) {
        beerServiceV2.deleteById(beerId);
    }

}
