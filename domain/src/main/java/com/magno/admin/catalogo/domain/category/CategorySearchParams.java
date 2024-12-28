package com.magno.admin.catalogo.domain.category;

public record CategorySearchParams(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction
) {
}
