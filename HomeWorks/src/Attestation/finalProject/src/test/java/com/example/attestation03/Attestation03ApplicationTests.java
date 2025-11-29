@SpringBootTest
class OwnerServiceTest {
    @Autowired
    private OwnerService ownerService;

    @Test
    void createAndGetOwner() {
        Owner owner = Owner.builder().fullName("Иван Иванов").apartmentNumber("12").address("ул. Пример 1").phone("123").build();
        Owner saved = ownerService.createOwner(owner);
        assertNotNull(saved.getId());

        Owner found = ownerService.getById(saved.getId());
        assertEquals("Иван Иванов", found.getFullName());
    }
}
