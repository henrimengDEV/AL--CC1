import application.MemberController;
import application.RoleController;
import domain.common.LoggerService;
import domain.event.DefaultEventBus;
import domain.event.EventBus;
import domain.member.*;
import domain.payment.PaymentService;
import domain.payment.RegisterMemberPaymentEventSubscription;
import domain.payment.RegisteredMemberPaymentEvent;
import domain.register.RegisterMemberEventSubscription;
import domain.register.RegisterService;
import domain.register.RegisteredMemberEvent;
import domain.role.CreateRole;
import domain.role.RoleService;
import domain.role.Roles;
import infrastructure.InMemoryMembers;
import infrastructure.InMemoryRoles;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        EventBus registerEventBus = initRegisterEventBus();
        EventBus paymentEventBus = initPaymentEventBus();
        LoggerService logger = new LoggerService();
        Roles roles = new InMemoryRoles();
        Members members = new InMemoryMembers();
        MemberService memberService = new MemberService(logger, members, roles);
        MemberController memberController = new MemberController(memberService);
        RoleService roleService = new RoleService(logger, roles);
        RoleController roleController = new RoleController(roleService);
        PaymentService paymentService = new PaymentService(logger, registerEventBus);
        RegisterService registerService = new RegisterService(logger, registerEventBus, memberService, paymentService);

        roleController.createFromRequest(new CreateRole(
                "TRADESMAN",
                new BigDecimal(99)
        ));

        registerService.register(new CreateMember(
                "Henri",
                "Meng",
                Login.of("hmeng@mail.fr", "123456")
        ));
    }

    public static DefaultEventBus initRegisterEventBus() {
        Map<Class<RegisteredMemberEvent>, List<RegisterMemberEventSubscription>> registerSubscriptionMap =
                Collections.singletonMap(
                        RegisteredMemberEvent.class,
                        Collections.singletonList(new RegisterMemberEventSubscription())
                );
        return new DefaultEventBus(registerSubscriptionMap);
    }

    public static DefaultEventBus initPaymentEventBus() {
        Map<Class<RegisteredMemberPaymentEvent>, List<RegisterMemberPaymentEventSubscription>> paymentSubscriptionMap =
                Collections.singletonMap(
                        RegisteredMemberPaymentEvent.class,
                        Collections.singletonList(new RegisterMemberPaymentEventSubscription())
                );
        return new DefaultEventBus(paymentSubscriptionMap);
    }
}
